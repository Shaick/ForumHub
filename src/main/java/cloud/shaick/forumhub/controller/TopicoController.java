package cloud.shaick.forumhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cloud.shaick.forumhub.dto.AtualizacaoTopicoDTO;
import cloud.shaick.forumhub.dto.TopicDTO;
import cloud.shaick.forumhub.model.Topic;
import cloud.shaick.forumhub.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
public class TopicoController {

    private static final Logger logger = LoggerFactory.getLogger(TopicoController.class);

    @Autowired
    private TopicoRepository topicoRepository;

    // Método para criar um novo tópico
    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic savedTopic = topicoRepository.save(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTopic);
    }

    // Método para listar todos os tópicos
    @GetMapping
    public List<TopicDTO> listarTopicos() {
        List<Topic> topics = topicoRepository.findAll(Sort.by(Sort.Direction.ASC, "dataCriacao"));
        return topics.stream()
                .map(TopicDTO::new) // Convertendo Topic para TopicDTO
                .collect(Collectors.toList());
    }

    // Método para listar tópicos paginados
    @GetMapping("/paginado")
    public Page<TopicDTO> listarTopicosPaginado(@PageableDefault(size = 10) Pageable pageable) {
        Page<Topic> topics = topicoRepository.findAll(pageable);
        return topics.map(TopicDTO::new); // Convertendo Page<Topic> para Page<TopicDTO>
    }

    // Método para detalhar um tópico por ID
    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> detalharTopico(@PathVariable Long id) {
        Optional<Topic> optionalTopic = topicoRepository.findById(id);
        if (optionalTopic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Topic topic = optionalTopic.get();
        return ResponseEntity.ok(new TopicDTO(topic)); // Convertendo Topic para TopicDTO
    }

    // Método para atualizar um tópico por ID
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> atualizarTopico(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoDTO atualizacaoTopicoDTO) {
        Optional<Topic> optionalTopic = topicoRepository.findById(id);
        if (optionalTopic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Topic topic = optionalTopic.get();

        try {
            topic.atualizarTopico(atualizacaoTopicoDTO);
            topicoRepository.save(topic); // Salva as alterações no banco de dados
            return ResponseEntity.ok(new TopicDTO(topic));
        } catch (EntityNotFoundException e) {
            logger.error("Tópico não encontrado com o ID " + id, e);
            return ResponseEntity.notFound().build();
        } catch (ValidationException e) {
            logger.error("Dados inválidos para atualização do tópico com ID " + id, e);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Erro ao atualizar o tópico com ID " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        Optional<Topic> optionalTopic = topicoRepository.findById(id);
        if (optionalTopic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        try {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Erro ao excluir o tópico com ID " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
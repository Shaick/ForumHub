package cloud.shaick.forumhub.dto;

import org.springframework.stereotype.Component;

import cloud.shaick.forumhub.model.Topic;

import java.time.LocalDateTime;

@Component
public record TopicDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String estado,
        String autor,
        String curso
) {

    public TopicDTO(Topic topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getEstado(),
                topico.getAutor(),
                topico.getCurso()
        );
    }

    // Construtor padrão vazio
    public TopicDTO() {
        this(null, null, null, null, null, null, null);
    }

}
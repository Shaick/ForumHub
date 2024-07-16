package cloud.shaick.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.shaick.forumhub.model.Topic;

public interface TopicoRepository extends JpaRepository<Topic, Long> {
}
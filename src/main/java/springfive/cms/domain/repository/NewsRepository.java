package springfive.cms.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springfive.cms.domain.models.News;

public interface NewsRepository extends MongoRepository<News, String> {
}
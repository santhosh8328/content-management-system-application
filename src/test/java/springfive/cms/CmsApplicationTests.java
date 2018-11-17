package springfive.cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;
import springfive.cms.domain.models.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void coldBehavior() {
		Category sports = new Category();
		sports.setName("sports");
		Category music = new Category();
		music.setName("music");
		Flux.just(sports, music).doOnNext(System.out::println).subscribe();
	}

	@Test
	public void hotBehavior() {
		UnicastProcessor<String> hotSource = UnicastProcessor.create();
		Flux<Category> hotPublisher = hotSource.publish().autoConnect()
				.map((String t) -> Category.builder().name(t).build());
		hotPublisher.subscribe(category -> System.out.println("Subscriber 1: " + category.getName()));
		hotSource.onNext("sports");
		hotSource.onNext("cars");
		hotPublisher.subscribe(category -> System.out.println("Subscriber 2: " + category.getName()));
		hotSource.onNext("games");
		hotSource.onNext("electronics");
		hotSource.onComplete();
	}

}

package gosuclass.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "evaluation", url = "${api.url.evaluation}")
public interface EvaluationService {

    // 기존의 preevaluate 메서드 (POST)
    @RequestMapping(method = RequestMethod.POST, path = "/evaluations")
    public void preevaluate(@RequestBody Evaluation evaluation);

    // 새로운 GET 메서드: ID로 Evaluation 조회
    @RequestMapping(method = RequestMethod.GET, path = "/evaluations/{id}")
    public Evaluation getEvaluationById(@PathVariable("id") Long id);
}
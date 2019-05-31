package ru.eremin.tm.client.task;

import feign.Feign;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import ru.eremin.tm.client.model.dto.ProjectDTO;
import ru.eremin.tm.client.model.dto.ResultDTO;

import java.util.List;

/**
 * @autor av.eremin on 29.05.2019.
 */

@FeignClient("projectClient")
public interface ProjectClient {

    static ProjectClient client(final String baseUrl) {
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new SpringEncoder(objectFactory))
                .decoder(new SpringDecoder(objectFactory))
                .target(ProjectClient.class, baseUrl);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<ProjectDTO> findAllProjects(@RequestHeader("Authorization") String token,
                                     @RequestParam(name = "userId") @Nullable final String userId);

    @GetMapping(value = "/findOne", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ProjectDTO findOneProject(@RequestHeader("Authorization") String token,
                              @RequestParam(name = "projectId") @Nullable final String projectId);

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResultDTO createProject(@RequestHeader("Authorization") String token,
                            @RequestBody @Nullable final ProjectDTO projectDTO);

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResultDTO updateProject(@RequestHeader("Authorization") String token,
                            @RequestBody @Nullable final ProjectDTO projectDTO);

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResultDTO deleteProject(@RequestHeader("Authorization") String token,
                            @RequestParam(name = "projectId") @Nullable final String projectId);

}

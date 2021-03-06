package ru.eremin.tm.rest.feign;

import feign.Feign;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import ru.eremin.tm.model.dto.UserDTO;
import ru.eremin.tm.model.dto.web.ResultDTO;

import java.util.List;

/**
 * @autor av.eremin on 29.05.2019.
 */
@FeignClient("userClient")
public interface UserClient {

    static UserClient client(final int port) {
        @Nullable final String baseUrl = "http://localhost:" + port + "/api/user";
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new SpringEncoder(objectFactory))
                .decoder(new SpringDecoder(objectFactory))
                .target(UserClient.class, baseUrl);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<UserDTO> findAllUsers(@RequestHeader("Authorization") String token);

    @GetMapping(value = "/findOne", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    UserDTO findOneUser(@RequestHeader("Authorization") String token,
                        @RequestParam(name = "userId") @Nullable final String userId);

    @GetMapping(value = "/findByLogin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    UserDTO findUserByLogin(@RequestHeader("Authorization") String token,
                            @RequestParam(name = "userLogin") @Nullable final String userLogin);

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResultDTO createUser(@RequestHeader("Authorization") String token,
                         @RequestBody @Nullable final UserDTO userDTO);

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResultDTO updateUser(@RequestHeader("Authorization") String token,
                         @RequestBody @Nullable final UserDTO userDTO);

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResultDTO deleteUser(@RequestHeader("Authorization") String token,
                         @RequestParam(name = "userId") @Nullable final String userId);

}

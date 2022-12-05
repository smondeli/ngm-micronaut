package com.oracle.mn.controller;

import com.oracle.mn.service.NGMService;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller("/")
public class NGMController {
    private final NGMService ngmService;

    public NGMController(NGMService ngmService) {
        this.ngmService = ngmService;
    }

    @Get("/trial")
    public String test1() {
        return ngmService.getItems().get(0).getName();
    }

    @View("login")
    @Get("/")
    public HttpResponse login() {
        return HttpResponse.ok();
    }

    @View("listing")
    @Get("/listing")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public HttpResponse listItems() {
        return HttpResponse.ok(CollectionUtils.mapOf("categories", ngmService.getCategories(),
                "items", ngmService.getItems()));
    }
}

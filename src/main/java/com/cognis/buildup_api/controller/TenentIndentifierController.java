package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.tenent.TenentIndentifierRequest;
import com.cognis.buildup_api.core.tenent.TenentIndentifierResponse;
import com.cognis.buildup_api.service.TenentIndentifierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenent")
public class TenentIndentifierController extends GenericController<TenentIndentifierRequest, TenentIndentifierResponse, Integer> {
    public TenentIndentifierController(TenentIndentifierService service) {
        super(service);
    }
}

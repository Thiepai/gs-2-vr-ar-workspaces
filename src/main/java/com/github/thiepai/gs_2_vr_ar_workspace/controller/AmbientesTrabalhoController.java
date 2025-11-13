package com.github.thiepai.gs_2_vr_ar_workspace.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmbientesTrabalhoController {

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        return Map.of(
            "tema", "Ambientes de trabalho com Realidade Virtual ou Aumentada",
            "membro1", "Gabriel Valério Gouveia",
            "membro2", "Thiago Ratão Passerini",
            "descricao", "Exploração de ambientes imersivos para colaboração e produtividade."
        );
    }
}
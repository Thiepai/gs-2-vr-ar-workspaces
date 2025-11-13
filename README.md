# **gs-2-vr-ar-workspaces**

## 👥 **Integrantes**
- **Gabriel Valério Gouveia** — RM: 552532  
- **Thiago Ratão Passerini** — RM: 551351  

---

## 📌 **Descrição do Tema**
**Ambientes de trabalho com Realidade Virtual ou Aumentada**  
Exploração de ambientes imersivos para colaboração e produtividade, utilizando tecnologias modernas para criar experiências inovadoras que aumentem a eficiência e a interação entre equipes.

---

## 🎯 **Finalidade da API**
Esta API foi desenvolvida como parte da Global Solution, com foco em integração alinhada ao tema proposto.  
O objetivo é projetar uma **API moderna, escalável e preparada para implantação em nuvem**, utilizando **dockerização**, documentação completa via **Swagger**, e um pipeline funcional de **CI/CD**.

---

## 🛠 **Tecnologias Utilizadas**
- **Java 21**
- **Spring Boot**
- **Swagger (OpenAPI)**
- **Docker**
- **GitHub Actions (CI/CD)**

---

## 🔗 **URLs Importantes**
- **Repositório GitHub:** https://github.com/Thiepai/gs-2-vr-ar-workspaces  
- **Imagem Docker Hub:** [https://hub.docker.com/repository/dockerthiepai/gs-2-vr-ar-workspaces/general  

---

## 🚀 **Como Executar Localmente**

### **Pré-requisitos**
- Java 21 instalado
- Maven instalado
- Docker (opcional para containerização)

---

### **Compile e execute:**
```bash
mvn spring-boot:run
```
---

### **Acesse a API:**
**Endpoint Principal**
```bash
GET http://localhost:8081/info
```
**Exemplo com curl:**
```bash
curl http://localhost:8081/info
```

---

### **Documentação Swagger:**
```bash
http://localhost:8081/swagger-ui/index.html
```

---

### **🐳 Executar via Docker**
**Baixe a imagem:**
```bash
docker pull thiepai/gs-2-vr-ar-workspaces:latest
```
**Execute o container:**
```bash
docker run -p 8081:8081 thiepai/gs-2-vr-ar-workspaces:latest
```

---

### **✅ Código Fonte Principal**
```java
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
```
---

### **📦 Dockerfile**
```dockerfile
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/gs-2-vr-ar-workspaces-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

### **🔄 Workflows CI/CD**
**1. Versionamento Automático**
```yaml
name: Versioning
on:
  push:
    branches:
      - main
jobs:
  create-tag:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Criar tag
        run: |
          VERSION=$(date +'%Y.%m.%d.%H%M')
          git tag $VERSION
          git push origin $VERSION
```
**2. Continuous Integration (CI)**
```yaml
name: CI
on:
  push:
    branches:
      - 'feature/**'
      - 'release'
      - 'hotfix'
jobs:
  build-test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
      - run: mvn clean package
      - run: mvn test
      - run: docker build -t test-image .
```
**3. Continuous Delivery (CD)**
```yaml
name: CD
on:
  pull_request:
    branches:
      - develop
jobs:
  docker-push:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
      - run: mvn clean package
      - name: Login Docker Hub
        uses: docker/login-action@v2
        with:
          username: ${{ secrets.DOCKER_USERNAME }}
          password: ${{ secrets.DOCKER_PASSWORD }}
      - run: docker build -t ${{ secrets.DOCKER_USERNAME }}/gs-2-vr-ar-workspaces:latest .
      - run: docker push ${{ secrets.DOCKER_USERNAME }}/gs-2-vr-ar-workspaces:latest
```
---

### **📌 Observações**

Porta padrão: 8081
Nome oficial do repositório: gs-2-vr-ar-workspaces

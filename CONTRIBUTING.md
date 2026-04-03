# Contributing to Telecom Observability Platform

Thank you for considering contributing to this project! 🎉

---

## 📋 Table of Contents

- [Project Architecture](#project-architecture)
- [Getting Started](#getting-started)
- [Branch Naming](#branch-naming)
- [Commit Convention](#commit-convention)
- [Opening a Pull Request](#opening-a-pull-request)

---

## 🏗️ Project Architecture
```
telecom-observability-platform/
├── frontend/        # Angular 19 — UI, WebSocket, Alerts, Dashboard
├── backend/         # Java Spring Boot — WebSocket STOMP, REST API, Kafka Consumer
├── etl/             # Python — Kafka Producer, ETL Pipeline (coming soon)
├── k8s/             # Kubernetes manifests (coming soon)
└── .github/
    └── workflows/   # CI/CD GitHub Actions (coming soon)
```

**Data flow:**
```
ETL Python → Kafka → Spring Boot → WebSocket STOMP → Angular
```

---

## 🚀 Getting Started

### Prerequisites

| Tool | Version |
|---|---|
| Node.js | 18+ |
| Angular CLI | 19+ |
| Java | 22 |
| Maven | 3.9+ |
| Python | 3.11+ |
| Docker | 24+ |

### Frontend
```bash
cd frontend
npm install
ng serve
# → http://localhost:4200
```

### Backend
```bash
cd backend
mvn spring-boot:run
# → http://localhost:8080
```

---

## 🌿 Branch Naming

| Type | Pattern | Example |
|---|---|---|
| Feature | `feat/<description>` | `feat/kafka-producer` |
| Bug fix | `fix/<description>` | `fix/websocket-reconnect` |
| Docs | `docs/<description>` | `docs/update-readme` |
| Refactor | `refactor/<description>` | `refactor/alert-service` |

---

## 📝 Commit Convention

This project follows [Conventional Commits](https://www.conventionalcommits.org/).
```
<type>(<scope>): <description>

feat(frontend): add alert filter by priority
fix(backend): handle kafka consumer timeout
docs(readme): update setup instructions
refactor(etl): simplify kafka producer logic
```

**Types:** `feat` · `fix` · `docs` · `refactor` · `test` · `chore`

---

## 🔀 Opening a Pull Request

1. Fork the repository
2. Create your branch: `git checkout -b feat/your-feature`
3. Commit your changes following the convention above
4. Push: `git push origin feat/your-feature`
5. Open a Pull Request against `main`
6. Describe what you changed and why

---

## 👤 Author

**Mohamed Ikbel Ben Nessib**
[github.com/ikbelbensib](https://github.com/ikbelbensib) · [linkedin.com/in/ikbelbennessib](https://linkedin.com/in/ikbelbennessib)
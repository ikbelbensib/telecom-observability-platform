# Telecom Observability Platform

A full-stack distributed platform for real-time telecom network monitoring, built with a modern enterprise-grade stack.

## Architecture

| Layer | Technology |
|-------|-----------|
| Data Ingestion | Python, Apache Kafka, Pandas |
| Database | PostgreSQL |
| Backend API | Java Spring Boot, Spring Cloud, WebSocket |
| Frontend | Angular 19, Chart.js, RxJS |
| Alerting | Node.js, Telegram Bot |
| Infrastructure | Docker, Kubernetes, Azure AKS |
| CI/CD | GitHub Actions |
| Monitoring | Prometheus, Grafana |

## Features

- Real-time network KPI dashboard (latency, error rate, availability, active cells)
- WebSocket live data streaming
- JWT authentication with route protection
- Intelligent alerting with Telegram notifications
- ETL pipeline for telecom data processing
- Full Kubernetes deployment with Helm charts

## Getting Started

### Prerequisites
- Node.js >= 18
- Angular CLI
- Docker Desktop
- Java 17+
- Python 3.10+

### Run the frontend locally
```bash
cd frontend
npm install
ng serve
```

Open http://localhost:4200 and login with `admin` / `admin`

## Project Structure
```
telecom-observability-platform/
├── frontend/        # Angular 19 dashboard
├── backend/         # Java Spring Boot API (coming soon)
├── etl-pipeline/    # Python ETL + Kafka consumer (coming soon)
├── alert-bot/       # Node.js Telegram bot (coming soon)
└── k8s/             # Kubernetes Helm charts (coming soon)
```

## Author

**Med Ikbel Ben Nessib** — Full Stack & Automation Engineer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue)](https://linkedin.com/in/ikbelbennessib)
[![GitHub](https://img.shields.io/badge/GitHub-ikbelbensib-black)](https://github.com/ikbelbensib)
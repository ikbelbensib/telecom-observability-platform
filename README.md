# Telecom Observability Platform

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.13-6DB33F?style=flat&logo=springboot)
![Angular](https://img.shields.io/badge/Angular-19-DD0031?style=flat&logo=angular)
![Kafka](https://img.shields.io/badge/Apache_Kafka-3.x-231F20?style=flat&logo=apachekafka)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=flat&logo=docker)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Manifests-326CE5?style=flat&logo=kubernetes)
![Python](https://img.shields.io/badge/Python-ETL_Producer-3776AB?style=flat&logo=python)

A real-time telecom network observability platform simulating P1/P2/P3 incident detection, live alerting via WebSocket, and event streaming with Kafka — fully containerized with Docker and deployable on Kubernetes.

## Architecture

    Angular 19 (Frontend)
          |
          v
    Spring Boot 3.5 (Backend)
      - REST API (JWT Auth)
      - WebSocket STOMP/SockJS (Live Alerts)
      - Scheduled AlertService (every 5s)
      - Kafka Consumer
          |
          v
    Apache Kafka + Zookeeper
          |
          v
    Python ETL Producer (etl/producer.py)

## Features

- JWT Authentication with AuthGuard and JwtInterceptor
- Live Dashboard with KPI cards and Chart.js real-time charts
- WebSocket Alerts via STOMP/SockJS for P1/P2/P3 incidents
- Kafka Streaming: Python ETL producer to Kafka topic to Spring consumer
- Docker Compose: full stack with one command
- Kubernetes: production-ready manifests for all services

## Project Structure

    telecom-observability-platform/
    +-- frontend/          # Angular 19
    +-- backend/           # Spring Boot 3.5.13
    +-- etl/               # Python Kafka Producer
    +-- k8s/               # Kubernetes manifests
    |   +-- namespace.yaml
    |   +-- kafka/
    |   +-- backend/
    |   +-- frontend/
    |   +-- ingress.yaml
    +-- docker-compose.yml

## Quick Start - Docker Compose

    docker-compose up --build

Services:
- Frontend: http://localhost:4200
- Backend:  http://localhost:8080
- Kafka:    localhost:9092

Login: admin / admin

## Quick Start - Kubernetes

    minikube start --memory=3500 --cpus=2
    minikube addons enable ingress
    kubectl apply -f k8s/namespace.yaml
    kubectl apply -f k8s/kafka/
    kubectl apply -f k8s/backend/
    kubectl apply -f k8s/frontend/
    kubectl apply -f k8s/ingress.yaml
    minikube tunnel

Then open http://telecom.local

## Tech Stack

| Layer      | Technology                           |
|------------|--------------------------------------|
| Frontend   | Angular 19, Chart.js, STOMP/SockJS   |
| Backend    | Spring Boot 3.5, Java 22, WebSocket  |
| Streaming  | Apache Kafka, Zookeeper              |
| ETL        | Python 3, kafka-python               |
| DevOps     | Docker, Docker Compose, Kubernetes   |

## Author

Med Ikbel Ben Nessib - https://github.com/ikbelbensib

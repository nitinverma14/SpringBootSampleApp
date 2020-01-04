### Jarvis Engine

This PoC is about to create a reusable multi-layered model to simplify an Integration & Communication Process. This consists of following components(to begin with):
  - Data Streaming via Apache Kafka
  - Rule engine via Drools/Spring Integration
  - Communication engine integrated with both SMS & SMTP gateway
  - Templates for messaging
  - CRUD model to push & pull user input data
  - API documentation
  - UI interface to provide all data entry forms & analysis
   
### Bind ConfigMap
Create a config-map `jarvis-engine-cm` with key `application.properties`

```sh
oc volume dc/jarvis-engine --overwrite --add -t configmap  -m /opt/config --name=jarvis-engine-cm --configmap-name=jarvis-engine-cm
```
   
### Deploy to OSE
```sh
oc new-app docker.optum.com/hkumar44/jarvis:engine --name=jarvis-engine
```"# SpringBootSampleApp" 

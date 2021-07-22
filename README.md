# Agents System Performance Test Suite
Performance test respository for agents system service.

## Running the tests
### Setup
Have the following services running:
- agents-frontend
- agents-registration-frontend
- agents-backend
- client-backend


### Run tests
To run all tests
```
sbt "gatling:test"
```
To run individual tests
```
sbt "gatling:testOnly agents.RegisterAgentSimulation"
```
```
sbt "gatling:testOnly agents.LogInSimulation"
```



## Collaborators
- Ayub Yusuf
- Ekip Kalir
- Isabel Lee
- Nathan Jackson
- Daniel Carter
- Chetan Pardeep

## Info
Project uses [sbt plugin][sbtplugindoc] of [gatling][gatlingdoc].
It contains basic simulation from gatling quick start bundle.

[sbtplugindoc]: https://gatling.io/docs/current/extensions/sbt_plugin/
[gatlingdoc]: https://gatling.io/docs/current/advanced_tutorial/

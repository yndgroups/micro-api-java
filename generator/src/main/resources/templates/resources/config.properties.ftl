server:
  port: 8300
  undertow:
    accesslog:
      dir: out/logs
      enabled: true
      pattern: '[%{time,yyyy-MM-dd HH:mm:ss.S z}] %a:%p "%r"  %s (%D ms)'
      prefix: ${spring.application.name}
      suffix: .log
    max-http-post-size: 0
    io-threads: 4
    worker-threads: 20
    buffer-size: 1024
    buffers-per-region: 1024
    direct-buffers: true

application:
  dataBase:
    ip: 数据库ip
    port: 数据库端口
    name: 你的数据库名称
    username: 你的数据库账号
    password: 你的数据库密码
  deleteType: 1 # 1:逻辑删除 2：物理删除
  appId: 应用id
  version: 1.0

spring:
  application:
    name: bigdataedu-content

  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  cloud:
    nacos:
      discovery:
        # ip: 127.0.0.1
        server-addr: 你的nacos地址
        namespace: 你的的naocs命名空间
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${application.dataBase.ip}:{application.dataBase.port}/${application.dataBase.name}?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true
    username: ${application.dataBase.username}
    password: ${application.dataBase.password}
    type: com.zaxxer.hikari.HikariDataSource
    hikari:
      minimum-idle: 10
      maximum-pool-size: 25
      auto-commit: true
      idle-timeout: 30000
      pool-name: ExpendHikariCP
      max-lifetime: 1800000
      connection-timeout: 30000
      connection-test-query: SELECT 1
  redis:
    host: 127.0.0.1
    port: 6379
    password: redis_pwd
    lettuce:
      pool:
        max-active: 100
        max-idle: 10
        max-wait: 100000
    timeout: 5000

swagger:
  enable: true
  title: ${spring.application.name}
  description: This is a licensing service

jwt:
  jwtPublicSecret: MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWCQ2KM0YeNsZG7Q8wtcxtsUzeuVcfv8WanSvKHkM2KdPizDoVzue/o9RSRViyLH/Om1L3o5tCNad2KgWHgSsKbZwUV8K4PdaNvZzQvCVZtCynUZGIOD9pT6n8hNcfGa0XMS2vJ1bD0psl4AyOut3JnbHvH22m5/CyKIn0XiSmuQIDAQAB
  jwtPrivateSecret: MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJYJDYozRh42xkbtDzC1zG2xTN65Vx+/xZqdK8oeQzYp0+LMOhXO57+j1FJFWLIsf86bUvejm0I1p3YqBYeBKwptnBRXwrg91o29nNC8JVm0LKdRkYg4P2lPqfyE1x8ZrRcxLa8nVsPSmyXgDI663cmdse8fbabn8LIoifReJKa5AgMBAAECgYADczPXgLRVD4dhrCPUR+nqf9A3suVY+oztsD2IiUecYDvaFD4lsDtOAdNpDOUsO6+4rYOr5Bw22or+QZsc8ZBuxOR/2c4xpIWVFHc5NRzayVpFotvHDgHBQ0sWLw0IlttI05WwsIxzYt+2UJB7T1LshX2kLw1oLvPEnWASLJwT3QJBANmM+XZUZ5DrcHYyqYrAuxMtvSrOZAkV2eUCvPSYEgs7L4KYiWHp65UCriJFFbBAJqTBQKHfVbTm+xatmbA2kgcCQQCwjV1rXGb6LD5lbkkcUXDlyOWK6ugV4irX0qesPRLZzjNMTsXr9nQhNb0sO1kjYK2aoepWje/4cI/5c8nUydE/AkEAqktNN5Bopat3FD8iMigeCKxEKM74xZfiQf87tGeZsEr7LMqEuC2pKLK5ZsAXcyk0VsGj+1Jcv8gTgrQP2z1MXwJBAKSCpRjkGgRk86M596AOdx92agVey/GQNBG09Y41vnn7fKtO/3fWxvEnDOXJS07+x+U9mIkcaw3ZfR6Y+OlxQKsCQQCsP8Kgn6C+mPLK214mXjGeh40BhT4CFoYQKMCzmNSLa4F5IxN0ZQgTQDu7kZRNTafSGIsr36cjGnSE1Yiwm+4C
  subject: sha1

redis:
  redisStoreTime: 7200

apijson:
  debug: true
  dataBase:
    host: jdbc:mysql://${application.dataBase.ip}:{application.dataBase.port}
    name: ${application.dataBase.name}
    account: ${application.dataBase.username}
    password: ${application.dataBase.password}

mybatis-plus:
  mapper-locations: classpath:mybatis/mapper/*.xml
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      logic-not-delete-value: 0
      logic-delete-value: 1

Article: test
Column:

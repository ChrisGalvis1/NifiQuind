Feature: Validar interacción con Apache Nifi
  Yo como integrante del equipo QA de Quind
  Quiero validar que Nifi se este ejecutando
  Para validar que en el flujo de datos se crea un archivo.csv

  Scenario Outline: Validar el flujo parametrizado en Nifi
    Given qa consulta si nifi se esta ejecutando
    When realiza la ejecucion del flujo parametrizado
    And realiza la consulta de nifi
    Then espera que el flujo pueda terminar
    And valida que el archivo csv fue creado y contenga los datos
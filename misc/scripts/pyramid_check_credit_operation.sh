#!/bin/bash

contract_scenarios=$(grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'operacaocredito' | wc -l | xargs)

grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'operacaocredito'

echo "$contract_scenarios cenários de Testes de Operações de Crédito"
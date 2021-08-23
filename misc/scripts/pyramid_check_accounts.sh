#!/bin/bash

contract_scenarios=$(grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'conta' | wc -l | xargs)

grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'conta'

echo "$contract_scenarios cenários de Testes de Contrato de Contas"
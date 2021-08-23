#!/bin/bash

contract_scenarios=$(grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'transacionalcartao' | wc -l | xargs)

grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'transacionalcartao'

echo "$contract_scenarios cenários de Testes de Transacional Cartão"
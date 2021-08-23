#!/bin/bash

contract_scenarios=$(grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'pessoa' | wc -l | xargs)

grep -E 'Scenario:' -d recurse * --include \*.feature | grep 'src/test/resources/features' | grep 'schema'  | grep 'pessoa'

echo "$contract_scenarios cenários de Testes de Pessoa"
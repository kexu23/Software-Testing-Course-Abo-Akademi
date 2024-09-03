*** Settings ***
Documentation    A test suite for the discount app
Library    ../resources/DiscountLibrary.py

*** Test Cases ***
Test 1
    Get discount   ${2}    ${True}
    Result should be    ${0}

Test 2
    Get discount   ${0}    ${True}
    Result should be    ${-1}

Test 3
    Get discount   ${10001}    ${True}
    Result should be    ${-1}

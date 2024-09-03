*** Settings ***
Documentation    A test suite for the discount app
Library    ../resources/DiscountLibrary.py

*** Test Cases ***
Test 1
    Get discount   ${0}    ${True}
    Result should be    ${-1}

Test 2
    Get discount   ${1}    ${True}
    Result should be    ${0}

Test 3
    Get discount   ${10000}    ${True}
    Result should be    ${1}

Test 4
    Get discount   ${10001}    ${True}
    Result should be    ${-1}

Test 5
    Get discount   ${0}    ${False}
    Result should be    ${-1}

Test 6
    Get discount   ${1}    ${False}
    Result should be    ${0}

Test 7
    Get discount   ${10000}    ${False}
    Result should be    ${1}

Test 8
    Get discount   ${10001}    ${False}
    Result should be    ${-1}
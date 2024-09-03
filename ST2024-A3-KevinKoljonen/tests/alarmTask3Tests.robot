*** Settings ***
Documentation    A test suite for the Alarm app
Library    ../resources/AlarmLibrary.py

Test Setup    ResetAlarm

*** Keywords ***
ResetAlarm
    [Documentation]    "We reset the alarm FSM before each test case to ensure test independence
    Reset
    Log To Console    "Reset"

Check Arm
    [Arguments]    ${expected}
    Arm
    Result Should Be    ${expected}

Check Close Doors
    [Arguments]    ${expected}
    Close Doors
    Result Should Be    ${expected}
    
Check Disarm
    [Arguments]    ${expected}
    Disarm
    Result Should Be    ${expected}
    
Check Open Doors
    [Arguments]    ${expected}
    Open Doors
    Result Should Be    ${expected}


*** Test Cases ***
Test 1
    Check Disarm    ${2}
    Check Close Doors    ${0}
    Check Disarm    ${2}
    Check Open Doors    ${0}
    Check Arm    ${0}
    
Test 2
    Check Arm    ${0}
    Check Arm    ${0}
    Check Close Doors    ${1}
    Check Arm    ${1}
    Check Open Doors    ${27}

Test 3
    Check Close Doors    ${0}
    Check Arm    ${1}
    Check Disarm    ${2}

Test 4
    Check Arm    ${0}
    Check Disarm    ${2}
    
Test 5
    Check Close Doors    ${0}
    Check Arm    ${1}
    Check Arm    ${1}
    Check Open Doors    ${27}


Feature: Lending Chanelling

  @dataDummy
  Scenario Outline: Generate Data Dummy Perseorangan and Approve
    Given Create Scenario "<Case1>""<Case2>"

    Examples:
      | Case1      | Case2      |
      | APPFILEIDV | REAFILEIDV |

  @approvementApproval
  Scenario Outline: Approval data Perseorangan
    Given open browser and login application using "<UserMaker>" and "<Pass>"
    And user bulk recomendation
    Then UserMaker logout application
    And login application using "<UserApprover>" and "<Pass>"
    Then UserApprover logout application

    Examples:
      | UserMaker | UserApprover | Pass      |
      | admin     | Approver     | 123456789 |

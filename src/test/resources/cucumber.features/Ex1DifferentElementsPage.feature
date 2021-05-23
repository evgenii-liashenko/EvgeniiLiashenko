Feature: Different Elements Page logging feature

  Scenario: Different Elements Page. Selecting elements.


    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown

    When I select 'Water' checkbox on Different Elements Page
    And I select 'Wind' checkbox on Different Elements Page
    And I select 'Selen' radio button on Different Elements Page
    And I select 'Yellow' in dropdown on Different Elements Page

   Then The top log row should be containing 'Water: condition changed to true' text in log section
    And The top log row should be containing 'Wind: condition changed to true' text in log section
    And The top log row should be containing 'metal: value changed to Selen' text in log section
    And The top log row should be containing 'Colors: value changed to Yellow' text in log section






# Initially I thought it was necessary to include all details into steps. Then I thought doing so would make the steps hard to read.
# Bellow is how I made them at first. Please leave a comment if it is necessary to include all details in such way.

  #    Given I open JDI GitHub site
#    And I login as user "Roman Iovlev" in user account menu in Menu Bar on Home Page
#    And I click on 'Service' button in menubar on Home Page
#    And I click on 'Different Elements' button in Service dropdown on Home Page
#    When I select Water checkbox in element section on Different Elements Page
#    And I select Wind checkbox in element section on Different Elements Page
#    And I select Selen radio button in element section on Different Elements Page
#    And I select Yellow in dropdown in element section on Different Elements Page
#    Then The top log row should be containing "Water: condition changed to true" text in log section on Different Elements Page
#    And The top log row should be containing "Wind: condition changed to true" text in log section on Different Elements Page
#    And The top log row should be containing "metal: value changed to Selen" text in log section on Different Elements Page
#    And The top log row should be containing "Colors: value changed to Yellow" text in log section on Different Elements Page

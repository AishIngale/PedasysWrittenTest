Feature: Contact Screen Form validation 
Scenario: Validate mandatory fields
Given Contact screen is opened
When User does not enter value in a <mandatoryField>
|Work Email|
|Telephone|

Then AppropriateMessage should be displayed.

Scenario: Work Email field validation
Given Contact screen is opened
When User enters incomplete value in Work Email field
Then AppropriateMessage should be displayed.

Scenario: Telephone field validation
Given Contact screen is opened
When User enters alphabetic value in Telephone field
Then AppropriateMessage should be displayed.


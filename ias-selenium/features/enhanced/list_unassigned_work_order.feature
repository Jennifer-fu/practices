Feature: unassigned work orders http://www.trouble.net.au/blog/korny/2009/11/03/behaviour-driven-development-with-cucumber-and-selenium/

Scenario: list unassigned work orders
Given I open danny page
When I check some unassigned work orders
Then I can assign them

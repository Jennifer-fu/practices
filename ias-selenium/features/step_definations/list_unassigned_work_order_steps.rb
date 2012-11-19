Given /^I open danny page$/ do
@page = UnassignedWorkOrderPage.new
@page.visit
end

When /^I check some unassigned work orders$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^I can assign them$/ do
  pending # express the regexp above with the code you wish you had
end
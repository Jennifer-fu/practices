class UnassignedWorkOrderPage
  PAGE_URL = "http://www.google.com"
  def initialize()
    @browser = $selenium_helper.browser
  end

  def visit
    @browser.open PAGE_URL
    @browser.wait_for_page_to_load
  end
end
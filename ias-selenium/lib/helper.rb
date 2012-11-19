require 'selenium/client'

class Helper
attr_accessor :max_timeout, :browser
    def initialize()
        @max_timeout = 45  # maximum allowed timeout
        @selenium_port = 4444
        @selenium_browser = "*iexplore"
        @selenium_process = nil
        @browser = nil
        start_browser
      end

    private

    def start_browser
        begin
          base_url = "http://localhost"
          @browser = Selenium::Client::Driver.new("localhost", @selenium_port, @selenium_browser, base_url, @max_timeout)
          @browser.start_new_browser_session
        rescue Exception
          raise
        end
      end

end
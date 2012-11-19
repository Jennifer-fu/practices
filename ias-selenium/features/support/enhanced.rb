require File.expand_path(File.dirname(__FILE__) + '/../../lib/helper.rb')
require File.expand_path(File.dirname(__FILE__) + '/../../lib/unassigned_work_order_page.rb')

$selenium_helper = Helper.new()  # better a global than a singleton - still need something global as it's used in monkey-patching bits below


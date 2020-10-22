class Object
  def abstract()
    raise AbstractMethodError
  end
end

class AbstractMethodError < StandardError
  
end
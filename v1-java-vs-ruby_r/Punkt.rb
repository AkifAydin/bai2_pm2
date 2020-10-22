class Punkt
    attr_reader :x, :y
    def initialize(x,y)
      @x=x
      @y=y
    end
    
    def abstand(p)
        Math.sqrt(((@y -p.y)**2 + (@x -p.x)**2))    
    end
            
    def to_s
      "(#@x,#@y)"
    end
end

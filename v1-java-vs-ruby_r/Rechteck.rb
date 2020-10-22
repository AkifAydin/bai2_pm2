require "./Figur"
class Rechteck
  include Figur
  def initialize(lu,hoehe=1,breite=1)
     @lu = lu
     @breite = breite 
     @hoehe = hoehe
   end

  def in(p)
    @lu.x <= p.x && p.x <= @lu.x+@breite && @lu.y <= p.y && p.y <= @lu.y+@hoehe
  end

  def to_s
    return "r(#{@lu},#@hoehe,#{@breite})"    
  end
end
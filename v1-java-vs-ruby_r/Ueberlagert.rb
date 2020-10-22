class Ueberlagert
  include Figur
  def initialize(oben,unten)
    @oben = oben
    @unten = unten    
  end

  def in(p)
    @oben.in(p) || @unten.in(p)
  end

  def to_s
    "ue(o=>#{@oben} u=>#{@unten})"
  end
end
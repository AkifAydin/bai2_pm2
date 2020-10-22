class Kreis
  include Figur
  def initialize(mitte,radius=1)
    @mitte = mitte
    @radius = radius
  end

  def in(p)
    @mitte.abstand(p) <= @radius
  end

  def to_s
    return "k(#{@mitte},#{@radius})"
  end
end
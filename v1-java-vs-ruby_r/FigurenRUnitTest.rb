require "test/unit"
require "./Rechteck"
require "./Kreis"
require "./Ueberlagert"
require "./Punkt"

class FigurenRUnitTest < Test::Unit::TestCase
  def setup()
    @r1 = Rechteck.new(Punkt.new(3,3))
    @r2 = Rechteck.new(Punkt.new(2.5,2.5))
    @r3 = Rechteck.new(Punkt.new(3.5,3.5))
    @k1 = Kreis.new(Punkt.new(3.5,4))
    @k2 = Kreis.new(Punkt.new(2,2),3)
    @k3 = Kreis.new(Punkt.new(3,4),1.5)
    @u1 = Ueberlagert.new(@r1,@r2)
    @u2 = Ueberlagert.new(@r3,@k1)
    @u3 = Ueberlagert.new(@k2,@k3)
    @u4 = Ueberlagert.new(@u1,@u2)
    @u5 = Ueberlagert.new(@u3,@u4)
    @punkt = Punkt.new(3,4);
  end
  
  def test_in()
    assert_true(@u5.in(@punkt))
    assert_true(@u4.in(@punkt))
    assert_true(@u3.in(@punkt))
    assert_true(@u2.in(@punkt))
    assert_true(@u1.in(@punkt))
    assert_true(@k2.in(@punkt))
    assert_true(@k1.in(@punkt))
    assert_false(@r3.in(@punkt))
    assert_false(@r2.in(@punkt))
    assert_true(@r1.in(@punkt))
  end
end
require "./Figur"
require "./Punkt"
require "./Kreis"
require "./Rechteck"
require "./Ueberlagert"

class FigurenTest
  
  r1 = Rechteck.new(Punkt.new(3,3))
  r2 = Rechteck.new(Punkt.new(2.5,2.5))
  r3 = Rechteck.new(Punkt.new(3.5,3.5))
  k1 = Kreis.new(Punkt.new(3.5,4))
  k2 = Kreis.new(Punkt.new(2,2),3)
  k3 = Kreis.new(Punkt.new(3,4),1.5)
  u1 = Ueberlagert.new(r1,r2)
  u2 = Ueberlagert.new(r3,k1)
  u3 = Ueberlagert.new(k2,k3)
  u4 = Ueberlagert.new(u1,u2)
  u5 = Ueberlagert.new(u3,u4)
  p u4
  
  punkt = Punkt.new(3,4);
  p u5.in(punkt)
  puts  u4.in(punkt)
  p u3.in(4)  # zeigt, dass die Typprüfung nur zur Laufzeit stattfindet
  p u3.in(punkt)
  p u2.in(punkt)
  p u1.in(punkt)
  p k2.in(punkt)
  p k1.in(punkt)
  p r3.in(punkt)
  p r2.in(punkt)
  p r1.in(punkt)

end
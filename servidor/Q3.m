clear all
clc
syms t x z a T
assume(a>0)

%x(t) = exp(-a*t) * (heaviside(t)-heaviside(t-T))
%transformada = fourier(x(t))


x(t) = 2*(heaviside(t)-heaviside(t-2))+ 2*(heaviside(t)-heaviside(t-1))
transformada = fourier(x(t))


transformada = simplify(transformada)
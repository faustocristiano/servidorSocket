clear all
clc
syms t x z a
%t = linspace(-20, 20, 5000);
%u = @(t) (t >= 0); 
assume(a>0)
x(t) = exp(-a*t) * heaviside(t);
transformada = fourier(x(t))
z=int(x(t).^2,[0 inf])
y=int(transformada,[0 inf])

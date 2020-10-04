/*
 * package SapientTest.DesignPattern;
 * 
 * import java.util.List;
 * 
 * interface Hotel { public Menu getMenus(); }
 * 
 * class NonVegRestaurant implements Hotel { public NonVegRestaurant getMenus()
 * { NonVegMenu nv = new NonVegMenu(); return nv; } }
 * 
 * 
 * class VegRestaurant implements Hotel { public Menus getMenus() { VegMenu v =
 * new VegMenu(); return v; } }
 * 
 * public class MyFacade {
 * 
 * public static void main(String[] args) {
 * 
 * // TODO Auto-generated method stub public VegMenu getVegMenu() {
 * VegRestaurant v = new VegRestaurant(); VegMenu vegMenu =
 * (VegMenu)v.getMenus(); return vegMenu; }
 * 
 * public NonVegMenu getNonVegMenu() { NonVegRestaurant v = new
 * NonVegRestaurant(); NonVegMenu NonvegMenu = (NonVegMenu)v.getMenus(); return
 * NonvegMenu; }
 * 
 * 
 * }
 * 
 * }
 */
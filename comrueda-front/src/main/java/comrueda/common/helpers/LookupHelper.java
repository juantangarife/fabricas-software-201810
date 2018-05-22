/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comrueda.common.helpers;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

public class LookupHelper {
 
    public static <T> T lookup(Class<T> interfaceRequired) {
        System.out.print("LOOKING UPPPPPPP!!!!!!"); 
        System.out.print("LOOKING UPPPPPPP!!!!!!"); 
        System.out.print("LOOKING UPPPPPPP!!!!!!"); 
        System.out.print("LOOKING UPPPPPPP!!!!!!"); 
        return lookup(interfaceRequired, null);
    }
     
    public static <T> T lookup(Class<T> interfaceRequired, String customFor) {
        try {
            InitialContext context = new InitialContext();
            if(context != null) {
                NamingEnumeration<NameClassPair> enumeration = context.list("java:app");
                while(enumeration.hasMoreElements()) {
                    NameClassPair obj = enumeration.next();
                    String subMatch= obj.getName();
                                        // Traversing all JNDI names and subtrees until a match is found.
                    T matched = lookup(interfaceRequired, "java:app/"+subMatch, customFor);
                    if(matched != null) {
                        return matched;
                    }
                }
            }
            return null;
        }
        catch(Exception e) {
            return null;
        }
         
        //return lookup(interfaceRequired, jndiRoot, null);
    }
     
     
     
     
    private static <T> T lookup(Class<T> interfaceRequired, String jndiRoot, String customFor) {
        try {
            InitialContext context = new InitialContext();
            if(context != null) {
                NamingEnumeration<NameClassPair> enumeration = context.list(jndiRoot);
                while(enumeration.hasMoreElements()) {
                    NameClassPair obj = enumeration.next();
                    if(obj.getName().contains(interfaceRequired.getCanonicalName())) {
                        T implementation = (T) context.lookup(jndiRoot+"/"+obj.getName());
                        return implementation;
                    }
                }
                 
            }
            return null;
        }
        catch(Exception e) {
            return null;
        }
    }
     
     
}

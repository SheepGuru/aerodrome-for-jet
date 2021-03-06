/**
 * This file is part of the Aerodrome package, and is subject to the 
 * terms and conditions defined in file 'LICENSE', which is part 
 * of this source code package.
 *
 * Copyright (c) 2016 All Rights Reserved, John T. Quinn III,
 * <johnquinn3@gmail.com>
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 */

package com.buffalokiwi.aerodrome.jet.orders;

import com.buffalokiwi.aerodrome.jet.Jsonable;
import com.buffalokiwi.aerodrome.jet.Utils;
import com.buffalokiwi.utils.Money;
import javax.json.Json;
import javax.json.JsonObject;


/**
 * A fee adjustment record 
 * @author John Quinn
 */
public class FeeAdjRec implements Jsonable
{
  /**
   * Adjustment name
   */
  private final String name;
  
  /**
   * Adjustment type
   */
  private final String type;
  
  /**
   * Commission Id 
   */
  private final String cid;
  
  /**
   * Adjustment value 
   */
  private final Money value;
  
  
  /**
   * Turn jet json into an instance of this
   * @param json jet json
   * @return instance
   */
  public static FeeAdjRec fromJson( final JsonObject json )
  {
    Utils.checkNull( json, "json" );
    
    return new FeeAdjRec(
      json.getString( "adjustment_name", "" ),
      json.getString( "adjustment_type", "" ),
      json.getString( "commission_id", "" ),
      Utils.jsonNumberToMoney( json, "value" )
    );
  }
  
  
  /**
   * Create a new Fee Adjustment Record
   * @param name Adjustment name 
   * @param type Adjustment type
   * @param cid Commission Id 
   * @param value Adjustment Value 
   */
  public FeeAdjRec(
    final String name,
    final String type,
    final String cid,
    final Money value
  ) {
    
    Utils.checkNull( name, "name" );
    Utils.checkNull( type, "type" );
    Utils.checkNull( cid, "cid" );
    Utils.checkNull( value, "value" );
        
    this.name = name;
    this.type = type;
    this.cid = cid;
    this.value = value;
  }
  
  
  /**
   * Get the adjustment name 
   * @return name
   */
  public String getName()
  {
    return name;
  }
  
  
  /**
   * Get the adjustment type
   * @return type
   */
  public String getType()
  {
    return type;
  }
  
  
  /**
   * Get the commission id 
   * @return cid 
   */
  public String getCommissionId()
  {
    return cid;
  }
  
  
  /**
   * get the adjustment value 
   * @return value 
   */
  public Money getValue()
  {
    return value;
  }
  
  
  /**
   * Turn this object into jet json 
   * @return json  
   */
  public JsonObject toJSON()
  {
    return Json.createObjectBuilder()
      .add( "adjustment_name", name )
      .add( "adjustment_type", type )
      .add( "commission_id", cid )      
      .add( "value", value.asBigDecimal())
      
      .build();
  }
}
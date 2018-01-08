/*
 * Copyright (c) 2006-2017 by Sebastian Duda, https://meinewebsite.org
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class BeerPhoto extends Photo {
    public BeerPhotoManager manager = new BeerPhotoManager();

    private Beer beer = new Beer();

    public BeerPhoto (){
        super();
    }

    public BeerPhoto (String brewery){
        super();
        beer = new Beer(BeerType.Types.Default, brewery);
    }

    public BeerPhoto (PhotoId id) {
        super(id);
    }

    public BeerPhoto (PhotoId id, String brewery){
        super(id);
        beer = new Beer(BeerType.Types.Default, brewery);
    }

    public BeerPhoto (PhotoId id, String brewery, BeerType.Types type){
        super(id);
        beer = new Beer(type, brewery);
    }

    public String getBrewery() {
        return beer.getBrewery();
    }

    public BeerType getType() {
        return beer.getType();
    }
}

/**
 * This file is part of RedstoneLamp.
 * <p>
 * RedstoneLamp is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * RedstoneLamp is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with RedstoneLamp.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.redstonelamp.response;

import net.redstonelamp.Player;

/**
 * Removes a Player from another Player (de-spawns)
 *
 * @author RedstoneLamp Team
 */
public class RemovePlayerResponse extends Response{
    public Player player;

    public RemovePlayerResponse(Player player){
        this.player = player;
    }
}

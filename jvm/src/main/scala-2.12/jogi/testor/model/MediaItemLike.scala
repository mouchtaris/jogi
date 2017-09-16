package jogi
package testor
package model

import record.`1:n`

/**
 * Created by nikos on 9/13/17.
 */
trait MediaItemLike extends (User `1:n` MediaItem)

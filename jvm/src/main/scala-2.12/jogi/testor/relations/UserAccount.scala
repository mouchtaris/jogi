package jogi
package testor
package relations

import record.`1-n`

trait UserAccount extends (Account `1-n` User)
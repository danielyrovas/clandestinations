package org.yrovas.clandestinations.data

import io.github.serpro69.kfaker.Faker
import kotlin.random.Random

data class Identity(
    val name: String,
    val agentID: Int,
    val disguiseID: Int,
    val address: String,
    val disguise: Disguise = StaticData.disguises[disguiseID],
)

fun randomIdentity(): Identity {
    val faker = Faker()
    return Identity(
        name = faker.name.nameWithMiddle(),
        agentID = Random.nextInt(0, 100),
        disguiseID = Random.nextInt(0, StaticData.disguises.size),
        address = faker.address.cityWithState(),
    )
}

package org.yrovas.clandestinations.data

import io.github.serpro69.kfaker.Faker
import org.yrovas.clandestinations.StaticData
import kotlin.random.Random

data class Identity(
    val name: String,
    val agentID: Int,
    val disguise: Disguise,
    val address: String,
)

fun randomIdentity(): Identity {
    val faker = Faker()
    return Identity(
        name = faker.name.nameWithMiddle(),
        agentID = Random.nextInt(0, 100),
        disguise = StaticData.disguises[Random.nextInt(0, StaticData.disguises.size)],
        address = faker.address.cityWithState()
    )
}

package org.yrovas.clandestinations

import io.github.serpro69.kfaker.Faker
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
        faker.name.nameWithMiddle(),
        Random.nextInt(0, 100),
        StaticData.disguises[Random.nextInt(0, 2)],
        faker.address.cityWithState()
    )
}

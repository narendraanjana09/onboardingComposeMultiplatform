data class OnboardingModel(
    val image:String,
    val title:String,
    val body:String
) {
    companion object {
        fun getList(): List<OnboardingModel> {
            val list = mutableListOf<OnboardingModel>()
            list.add(OnboardingModel(
                image = "img1.png",
                title = "Welcome to\nArchitect Engineer",
                body = "Explore a range of services, from architectural plans to 3D renderings. Immerse yourself in our portfolio showcasing precision and creativity."
            ))
            list.add(OnboardingModel(
                image = "img2.png",
                title = "Exclusive Ebooks",
                body = "Unlock a world of architectural inspiration with our exclusive ebooks. Dive into samples that guide and inspire your design journey."
            ))
            list.add(OnboardingModel(
                image = "img3.png",
                title = "Interior Designs",
                body = "Discover transformative interior designs that harmonize functionality and aesthetics. Elevate your living and working spaces with our expert touch."
            ))
            list.add(OnboardingModel(
                image = "img4.png",
                title = "Elevation Designs",
                body = "Experience awe-inspiring elevations that redefine skylines. Our designs reach new heights, creating spaces that captivate and inspire."
            ))
            return list
        }
    }
}